package org.iitj.catalog.model;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Pattern {
    private String key;
    private String name;
    private String summary;
    private String complexity;     // Low/Medium/High
    private String deployment;     // Monolith/Distributed/Hybrid/Serverless
    private String primaryDriver;  // Throughput/Latency/Team Autonomy/...
    private List<String> pros;
    private List<String> cons;
    private List<String> mitigations;
    private List<String> whenToUse;
    private List<String> whenNotToUse;
    private List<String> similar;
    private List<String> examples;
    private String reasonMatched;
}
