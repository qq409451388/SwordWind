package com.poethan.swordwindmemcache.data;

import lombok.Data;

@Data
public class SetExecuter extends CommandExecuter {
    private String key;
    private String value;
}
