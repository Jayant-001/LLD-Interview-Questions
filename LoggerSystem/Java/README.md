
# Logger System

It is an example of the Chain of Responsibility pattern, a behavioral design pattern.

The logger design allows for handling different levels of log messages (INFO, DEBUG, ERROR) by passing them through a chain of log processors. Each processor handles a specific log level, and if the current processor cannot handle the log level, it forwards the request to the next processor in the chain.

The hierarchy of the chain looks like this:

    1. InfoLogProcessor handles INFO logs.
    2. DebugLogProcessor handles DEBUG logs.
    3. ErrorLogProcessor handles ERROR logs.


This means:

* The InfoLogProcessor is at the head of the chain.
* It delegates to the DebugLogProcessor.
* The DebugLogProcessor delegates to the ErrorLogProcessor.
* The ErrorLogProcessor is the last in the chain (i.e., its nextLogProcessor is null).