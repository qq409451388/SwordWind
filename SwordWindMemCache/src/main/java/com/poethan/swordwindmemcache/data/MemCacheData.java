package com.poethan.swordwindmemcache.data;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class MemCacheData implements Serializable {
    private CommandEnum command;
    private CommandExecuter data;
}
