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

import org.apache.commons.rdf.api.IRI;

/**
 * RDF Terms from the Dublin Core Vocabulary.
 *
 * @author acoburn
 * @see <a href="http://dublincore.org/documents/dces/">DCMI Metadata Elements</a>
 */
public final class DCElements {

    /* Namespace */
    public static final String URI = "http://purl.org/dc/elements/1.1/";

    /* Properties */
    public static final IRI contributor = VocabUtils.createIRI(URI + "contributor");
    public static final IRI coverage = VocabUtils.createIRI(URI + "coverage");
    public static final IRI creator = VocabUtils.createIRI(URI + "creator");
    public static final IRI date = VocabUtils.createIRI(URI + "date");
    public static final IRI description = VocabUtils.createIRI(URI + "description");
    public static final IRI format = VocabUtils.createIRI(URI + "format");
    public static final IRI identifier = VocabUtils.createIRI(URI + "identifier");
    public static final IRI language = VocabUtils.createIRI(URI + "language");
    public static final IRI publisher = VocabUtils.createIRI(URI + "publisher");
    public static final IRI relation = VocabUtils.createIRI(URI + "relation");
    public static final IRI rights = VocabUtils.createIRI(URI + "rights");
    public static final IRI source = VocabUtils.createIRI(URI + "source");
    public static final IRI subject = VocabUtils.createIRI(URI + "subject");
    public static final IRI title = VocabUtils.createIRI(URI + "title");
    public static final IRI type = VocabUtils.createIRI(URI + "type");


    private DCElements() {
    }
}
