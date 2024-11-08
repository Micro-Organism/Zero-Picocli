package com.zero.picocli.common.config;

import com.zero.picocli.common.command.MailCommand;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.context.annotation.Configuration;
import picocli.CommandLine;

@Configuration
public class PicocliConfig implements CommandLineRunner, ExitCodeGenerator {

    private CommandLine.IFactory factory;
    private MailCommand mailCommand;
    private int exitCode;

    // constructor injection
    PicocliConfig(CommandLine.IFactory factory, MailCommand mailCommand) {
        this.factory = factory;
        this.mailCommand = mailCommand;
    }

    @Override
    public void run(String... args) {
        // let picocli parse command line args and run the business logic
        exitCode = new CommandLine(mailCommand, factory).execute(args);
    }

    @Override
    public int getExitCode() {
        return exitCode;
    }

}
