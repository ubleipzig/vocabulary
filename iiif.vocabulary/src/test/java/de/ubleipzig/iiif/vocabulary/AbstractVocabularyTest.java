/*
 * Vocabulary
 * Copyright (C) 2018 Leipzig University Library <info@ub.uni-leipzig.de>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

package de.ubleipzig.iiif.vocabulary;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toSet;
import static org.apache.jena.graph.Factory.createDefaultGraph;
import static org.apache.jena.graph.Node.ANY;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.slf4j.LoggerFactory.getLogger;

import java.lang.reflect.Field;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import org.apache.jena.graph.Graph;
import org.apache.jena.graph.Node;
import org.apache.jena.graph.Triple;
import org.apache.jena.riot.RDFParser;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

/**
 * @author acoburn
 */
public abstract class AbstractVocabularyTest {

    private static final Logger LOGGER = getLogger(AbstractVocabularyTest.class);

    private static final String ACCEPT = "text/turtle, application/rdf+xml, application/ld+json";

    public abstract String namespace();

    public abstract String url();

    public abstract Class<?> vocabulary();

    public Boolean isStrict() {
        return true;
    }

    private String resolveUrl() {
        if (url() == null) {
            return namespace();
        } else {
            return url();
        }
    }

    protected Graph getVocabulary(final String url) {
        final Graph graph = createDefaultGraph();
        RDFParser.source(url).httpAccept(ACCEPT).parse(graph);
        return graph;
    }

    @Test
    public void testVocabulary() {
        final String url = resolveUrl();

        final Graph graph = getVocabulary(url);

        final Set<String> subjects = graph.find(ANY, ANY, ANY).mapWith(Triple::getSubject).filterKeep(
                Node::isURI).mapWith(Node::getURI).filterKeep(Objects::nonNull).toSet();

        fields().forEach(field -> {
            if (isStrict()) {
                assertTrue(
                        subjects.contains(namespace() + field),
                        "Field definition is not in published ontology! " + field);
            } else if (!subjects.contains(namespace() + field)) {
                LOGGER.warn("Field definition is not in published ontology! {}", field);
            }
        });
    }

    @Test
    public void testVocabularyRev() {
        final String url = resolveUrl();

        final Graph graph = getVocabulary(url);

        final Set<String> subjects = fields().map(namespace()::concat).collect(toSet());

        assertTrue(subjects.size() > 0, "Unable to extract field definitions!");

        graph.find(ANY, ANY, ANY).mapWith(Triple::getSubject).filterKeep(Node::isURI).mapWith(Node::getURI).filterKeep(
                Objects::nonNull).filterKeep(uri -> uri.startsWith(namespace())).filterDrop(
                namespace()::equals).filterDrop(subjects::contains).forEachRemaining(uri -> {
            LOGGER.warn("{} not defined in {} class", uri, vocabulary().getName());
        });
    }

    @Test
    public void testNamespace() throws Exception {
        final Optional<Field> uri = stream(vocabulary().getFields()).filter(
                field -> field.getName().equals("URI")).findFirst();

        assertTrue(uri.isPresent(), vocabulary().getName() + " does not contain a 'URI' field!");
        assertEquals(namespace(), uri.get().get(null), "Namespaces do not match!");
    }

    private Stream<String> fields() {
        return stream(vocabulary().getFields()).map(Field::getName).map(
                name -> name.endsWith("_") ? name.substring(0, name.length() - 1) : name).filter(
                field -> !field.equals("URI")).filter(field -> !field.equals("CONTEXT")).filter(
                field -> !field.equals("IMAGE-CONTEXT")).filter(field -> !field.equals("SERVICE-PROFILE"));
    }
}
