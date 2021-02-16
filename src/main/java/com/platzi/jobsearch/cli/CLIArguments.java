package com.platzi.jobsearch.cli;

import com.beust.jcommander.Parameter;

public class CLIArguments {
    CLIArguments(){
        // this empty constructor prevent new instances creation
    }

    private String keyword;
    private String location;
    private int page = 0;
    private boolean isFullTime = false;
    private boolean isMarkdown = false;
    private boolean isHelp;

    // tell commander that this property is prompted
    // on the command line
    @Parameter(
            required = true,
            descriptionKey = "KEYWORD",
            description = "Job name or keyword"
    )
    public String getKeyword() {
        return keyword;
    }
    @Parameter(
            names = {"--location", "-l"},
            description = "Job or company location"
    )
    public String getLocation() {
        return location;
    }
    @Parameter(
            names = {"--page", "-p"},
            description = "Each page has 50 results, default page is 0"
    )
    public int getPage() {
        return page;
    }
    @Parameter(
            names = "--full-time",
            description = "Add this flag if you want a full time job"
    )
    public boolean isFullTime() {
        return isFullTime;
    }
    @Parameter(
            names = "--markdown",
            description = "View results in Markdown format"
    )
    public boolean isMarkdown() {
        return isMarkdown;
    }
    @Parameter(
            names = {"--help"},
            help = true,
            description = "view API commands list"
    )
    public boolean isHelp() {
        return isHelp;
    }

    @Override
    public String toString() {
        return "CLIArguments{" +
                "keyword='" + keyword + '\'' +
                ", location='" + location + '\'' +
                ", page=" + page +
                ", isFullTime=" + isFullTime +
                ", isMarkdown=" + isMarkdown +
                ", isHelp=" + isHelp +
                '}';
    }

    public static CLIArguments newInstance() {
        // separe new instances logic from constructor
        return new CLIArguments();
    }
}
