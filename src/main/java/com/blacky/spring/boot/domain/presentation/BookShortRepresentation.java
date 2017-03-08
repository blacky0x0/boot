package com.blacky.spring.boot.domain.presentation;

import java.io.Serializable;

public interface BookShortRepresentation extends Serializable {

    Long getId();
    String getTitle();
    String getDescription();
    String getAuthor();

}
