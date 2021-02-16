package com.platzi.jobsearch;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class CommanderFunctions {
    static <T> JCommander buildCommanderWithName(
            String CLIName, Supplier<T> argumentSupplier
    ) {
        JCommander jCommander = JCommander.newBuilder()
                .addCommand(argumentSupplier.get())
                .build();

        jCommander.setProgramName(CLIName);
        return jCommander;
    }

    static Optional<List<Object>> parseArguments(
            JCommander jCommander,
            String[] args,
            Consumer<JCommander> onError
    ){
        try {
            jCommander.parse(args);
            return Optional.of(jCommander.getObjects());
        } catch (ParameterException exception) {
            // catch exceptions from validator
            onError.accept(jCommander);
        }

        return Optional.empty();
    }
}
