package org.iitj.catalog.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.iitj.catalog.model.Pattern;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class PatternFileService {

    private final List<Pattern> patterns;

    public PatternFileService() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        InputStream is = getClass().getResourceAsStream("/data/patterns.json");

        if (is == null) {
            throw new IllegalStateException("patterns.json not found in /data directory");
        }

        this.patterns = mapper.readValue(is, new TypeReference<List<Pattern>>() {});
    }

    public List<Pattern> all() {
        return patterns;
    }

    public Pattern findByKey(String key) {
        return patterns.stream()
                .filter(p -> p.getKey().equalsIgnoreCase(key) || p.getName().equalsIgnoreCase(key))
                .findFirst()
                .orElse(null);
    }
}
