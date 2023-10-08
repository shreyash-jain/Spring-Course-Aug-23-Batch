package com.shreyash.demo;


import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.IOException;
import java.io.InputStream;

@Setter
@Getter
@ToString

public class Todo {
    public Integer id;


    public String name;



}


// JAVA -> Source Code -> compiling -> bytecode
// .java -> .class -> byte data -> JVM