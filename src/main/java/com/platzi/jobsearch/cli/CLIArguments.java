package com.platzi.jobsearch.cli;

import com.beust.jcommander.Parameter;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
// this empty constructor prevent new instances creation
@NoArgsConstructor
public class CLIArguments {
    // tell commander that this property is prompted
    // on the command line
    @Parameter(
            required = true,
            descriptionKey = "KEYWORD",
            validateWith = CLIKeywordValidator.class,
            description = "Job name or keyword"
    )
    private String keyword;
    @Parameter(
            names = {"--location", "-l"},
            description = "Job or company location"
    )
    private String location;
    @Parameter(
            names = {"--page", "-p"},
            description = "Each page has 50 results, default page is 0"
    )
    private int page = 0;
    @Parameter(
            names = "--full-time",
            description = "Add this flag if you want a full time job"
    )
    private boolean isFullTime = false;
    @Parameter(
            names = "--markdown",
            description = "View results in Markdown format"
    )
    private boolean isMarkdown = false;
    @Parameter(
            names = {"--help"},
            help = true,
            validateWith = CLIHelpValidator.class,
            description = "view API commands list"
    )
    private boolean isHelp;
    @Parameter(
            names = "--min",
            description = "Show short results"
    )
    private boolean isMinResult;

    @Override
    public String toString() {
        return "CLIArguments{" +
                "keyword='" + keyword + '\'' +
                ", location='" + location + '\'' +
                ", page=" + page +
                ", isFullTime=" + isFullTime +
                ", isMarkdown=" + isMarkdown +
                ", isHelp=" + isHelp +
                ", isMinResult=" + isMinResult +
                '}';
    }

    public static CLIArguments newInstance() {
        // separe new instances logic from constructor
        return new CLIArguments();
    }
}
