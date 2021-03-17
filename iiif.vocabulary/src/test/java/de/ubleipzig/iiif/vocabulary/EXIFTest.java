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

/**
 * Test the EXIF Vocabulary Class
 *
 * @author acoburn
 */
public class EXIFTest extends AbstractVocabularyTest {

    @Override
    public String namespace() {
        return "https://www.w3.org/2003/12/exif/ns#";
    }

    @Override
    public String url() {
        return null;
    }

    @Override
    public Class<EXIF> vocabulary() {
        return EXIF.class;
    }
}
