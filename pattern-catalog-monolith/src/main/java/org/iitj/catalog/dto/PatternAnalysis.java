package org.iitj.catalog.dto;

import java.util.List;
import java.util.Map;

/**
 * Represents the analysis of architectural patterns from user input.
 * @param ask The original user input string.
 * @param patterns A list of matching architectural patterns found.
 * @param found A boolean indicating if any pattern was found.
 * @param response The total number of patterns found.
 * @param explanation A map where the key is the pattern name and the value is the reason it matched.
 */
public record PatternAnalysis(
        String ask,
        List<String> patterns,
        boolean found,
        int response,
        Map<String, String> explanation
) {
}