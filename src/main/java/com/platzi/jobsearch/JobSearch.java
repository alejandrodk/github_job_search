package com.platzi.jobsearch;

import com.beust.jcommander.JCommander;
import com.platzi.jobsearch.api.APIJobs;
import com.platzi.jobsearch.cli.CLIArguments;
import com.platzi.jobsearch.cli.CLIFunctions;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static com.platzi.jobsearch.CommanderFunctions.buildCommanderWithName;
import static com.platzi.jobsearch.CommanderFunctions.parseArguments;
import static com.platzi.jobsearch.api.APIFunctions.buildApi;

public class JobSearch {
    public static void main(String[] args) {
        System.out.println("Hello Job Search!!");
        JCommander jCommander = buildCommanderWithName("job-search", CLIArguments::newInstance);

        Stream<CLIArguments> streamOfCLI =
                parseArguments(jCommander, args, JCommander::usage)
                .orElse(Collections.emptyList())
                .stream()
                .map(obj -> (CLIArguments) obj);

        Optional<CLIArguments> cliArgumentsOptional =
                streamOfCLI.filter(cli -> !cli.isHelp())
                .filter(cli -> cli.getKeyword() != null)
                .findFirst();

        cliArgumentsOptional.map(CLIFunctions::toMap)
                .map(JobSearch::executeRequest)
                .orElse(Stream.empty())
                .forEach(job -> {
                    if(job.isShowMinResult()) {
                        System.out.println(job.toMinString());
                    } else {
                        System.out.println(job);
                    }
                });
    }

    private static Stream<JobPosition> executeRequest(Map<String, Object> params) {
        String GITHUB_API = "https://jobs.github.com";
        APIJobs api = buildApi(APIJobs.class, GITHUB_API);

        return Stream.of(params)
                .map(api::jobs)
                .flatMap(Collection::stream)
                .peek(job -> JobPosition.updateJobStructure(params, job));
    }
}
