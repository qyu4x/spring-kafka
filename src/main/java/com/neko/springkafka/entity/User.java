package com.neko.springkafka.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    private String id;

    private String username;

    private String email;

}
