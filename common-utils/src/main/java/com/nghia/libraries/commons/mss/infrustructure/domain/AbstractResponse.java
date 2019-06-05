package com.nghia.libraries.commons.mss.infrustructure.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AbstractResponse extends AbstractObject {
    private String code;
    private String message;
    private Object error;
    private Object body;

}