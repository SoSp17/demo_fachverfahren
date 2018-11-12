package de.scag.demofachverfahren.paasdemo.servicekonto;

import org.apache.commons.lang3.RegExUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;


/**
 * The Class ServiceKontoContentsPreparationServiceImpl.
 *
 * @author mertinat
 * @since 13.07.2017
 */
@Service
public class ServiceKontoContentsPreparationServiceImpl
        implements ServiceKontoContentsPreparationService {
    private static final char[] PROBLEM_CHARS = {
            0, 1, 2, 3, 4, 5, 6, 7, 8, 11, 12, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26,
            27, 28, 29, 30, 31, 37, 38, 60, 62
    };

    /* (non-Javadoc)
     * @see de.verwalt_berlin.senbjw.isbj.servicekonto.service.ServiceKontoContentsPreparationService#prepareForNachricht(java.lang.String)
     */
    @Override
    public String prepareForNachricht(final String inhalt) {
        String cleanedContent = inhalt;
        cleanedContent = filterProblemchars(cleanedContent);
        cleanedContent = filterWhitespaces(cleanedContent);

        return cleanedContent;
    }

    private String filterWhitespaces(final String inhalt) {
        return RegExUtils.replacePattern(inhalt, "\\s+", " ");
    }

    private String filterProblemchars(final String inhalt) {
        String cleanedContent = inhalt;

        for (final char problemChar : PROBLEM_CHARS) {
            cleanedContent = StringUtils.replaceChars(cleanedContent,
                    String.valueOf(problemChar),
                    "");
        }

        return cleanedContent;
    }
}
