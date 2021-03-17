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
 * along with this program.  If not, see <https://www.gnu.org/licenses/>
 */

package de.ubleipzig.iiif.vocabulary;

import static de.ubleipzig.iiif.vocabulary.VocabUtils.createIRI;

import org.apache.commons.rdf.api.IRI;

/**
 * RDF Terms from the Dublin Core Vocabulary.
 *
 * @author acoburn
 * @see <a href="https://dublincore.org/documents/dcmi-terms/">DCMI Metadata Terms</a>
 */
public final class DCTypes {

    /* Namespace */
    public static final String URI = "https://purl.org/dc/dcmitype/";

    /* Classes */
    public static final IRI Collection = createIRI(URI + "Collection");
    public static final IRI Dataset = createIRI(URI + "Dataset");
    public static final IRI Event = createIRI(URI + "Event");
    public static final IRI Image = createIRI(URI + "Image");
    public static final IRI InteractiveResource = createIRI(URI + "InteractiveResource");
    public static final IRI MovingImage = createIRI(URI + "MovingImage");
    public static final IRI PhysicalObject = createIRI(URI + "PhysicalObject");
    public static final IRI Service = createIRI(URI + "Service");
    public static final IRI Software = createIRI(URI + "Software");
    public static final IRI Sound = createIRI(URI + "Sound");
    public static final IRI StillImage = createIRI(URI + "StillImage");
    public static final IRI Text = createIRI(URI + "Text");

    /* Properties */

    private DCTypes() {
    }
}