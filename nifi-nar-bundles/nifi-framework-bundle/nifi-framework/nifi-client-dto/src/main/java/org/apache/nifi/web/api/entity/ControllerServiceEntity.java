/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.nifi.web.api.entity;

import javax.xml.bind.annotation.XmlRootElement;

import io.swagger.annotations.ApiModelProperty;
import org.apache.nifi.web.api.dto.ControllerServiceDTO;
import org.apache.nifi.web.api.dto.PermissionsDTO;
import org.apache.nifi.web.api.dto.status.ControllerServiceStatusDTO;

/**
 * A serialized representation of this class can be placed in the entity body of a response to the API. This particular entity holds a reference to a controller service.
 */
@XmlRootElement(name = "controllerServiceEntity")
public class ControllerServiceEntity extends ComponentEntity implements Permissible<ControllerServiceDTO>, OperationPermissible {

    private String parentGroupId;
    private ControllerServiceDTO component;
    private PermissionsDTO operatePermissions;
    private ControllerServiceStatusDTO status;

    /**
     * @return The id for the parent group of this ControllerService
     */
    @ApiModelProperty(
            value = "The id of parent process group of this ControllerService."
    )
    public String getParentGroupId() {
        return parentGroupId;
    }

    public void setParentGroupId(String parentGroupId) {
        this.parentGroupId = parentGroupId;
    }

    /**
     * @return controller service that is being serialized
     */
    public ControllerServiceDTO getComponent() {
        return component;
    }

    public void setComponent(ControllerServiceDTO component) {
        this.component = component;
    }

    /**
     * @return The permissions for this component operations
     */
    @ApiModelProperty(
            value = "The permissions for this component operations."
    )
    @Override
    public PermissionsDTO getOperatePermissions() {
        return operatePermissions;
    }

    @Override
    public void setOperatePermissions(PermissionsDTO permissions) {
        this.operatePermissions = permissions;
    }

    /**
     * @return The status for this ControllerService
     */
    @ApiModelProperty(
            value = "The status for this ControllerService.",
            readOnly = true
    )
    public ControllerServiceStatusDTO getStatus() {
        return status;
    }

    public void setStatus(ControllerServiceStatusDTO status) {
        this.status = status;
    }

}
