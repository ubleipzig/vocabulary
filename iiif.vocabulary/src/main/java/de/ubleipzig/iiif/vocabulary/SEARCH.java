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
/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.ubleipzig.iiif.vocabulary;

import static de.ubleipzig.iiif.vocabulary.VocabUtils.createIRI;

import org.apache.commons.rdf.api.IRI;

public final class SEARCH {

    /* CONTEXT */
    public static final String CONTEXT = "https://iiif.io/api/search/0/context.json";

    public static final String URI = "https://iiif.io/api/search/0#";

    /* Properties */
    public static final IRI ignored = createIRI(URI + "ignored");
    public static final IRI match = createIRI(URI + "match");
    public static final IRI before = createIRI(URI + "before");
    public static final IRI after = createIRI(URI + "after");
    public static final IRI count = createIRI(URI + "count");
    public static final IRI hasHitList = createIRI(URI + "hasHitList");
    public static final IRI hasTermList = createIRI(URI + "hasTermList");
    public static final IRI refines = createIRI(URI + "refines");
    public static final IRI hasSelector = createIRI(URI + "hasSelector");

    private SEARCH() {
        super();
    }

}
