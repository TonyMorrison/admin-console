/**
 * Copyright (c) Codice Foundation
 * <p>
 * This is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser
 * General Public License as published by the Free Software Foundation, either version 3 of the
 * License, or any later version.
 * <p>
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details. A copy of the GNU Lesser General Public License
 * is distributed along with this program and can be found at
 * <http://www.gnu.org/licenses/lgpl.html>.
 */

package org.codice.ddf.admin.api.handler.method;

import java.util.List;
import java.util.Map;

import org.codice.ddf.admin.api.config.Configuration;
import org.codice.ddf.admin.api.handler.report.ProbeReport;

import com.google.gson.annotations.Expose;

public abstract class ProbeMethod<S extends Configuration> extends ConfigurationHandlerMethod {

    @Expose
    final List<String> returnTypes;

    // TODO: tbatie - 1/12/17 - (Ticket) Remove this constructor and enforce the returnTypes field
    public ProbeMethod(String id, String description, List<String> requiredFields,
            List<String> optionalFields, Map<String, String> successTypes,
            Map<String, String> failureTypes, Map<String, String> warningTypes) {
        super(id,
                description,
                requiredFields,
                optionalFields,
                successTypes,
                failureTypes,
                warningTypes);
        this.returnTypes = null;
    }

    public ProbeMethod(String id, String description, List<String> requiredFields,
            List<String> optionalFields, Map<String, String> successTypes,
            Map<String, String> failureTypes, Map<String, String> warningTypes, List<String> returnTypes) {
        super(id,
                description,
                requiredFields,
                optionalFields,
                successTypes,
                failureTypes,
                warningTypes);

        this.returnTypes = returnTypes;
    }

    public abstract ProbeReport probe(S configuration);

    public List<String> getReturnTypes() {
        return this.returnTypes;
    }
}
