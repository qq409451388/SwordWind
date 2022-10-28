package com.poethan.swordwindmemcache.data;

import lombok.Data;

@Data
public class GetExecuter extends CommandExecuter {
    private String key;
}
