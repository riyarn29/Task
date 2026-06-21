public class BankStatementBatchProcessor {

    private int processedCount = 0;

private synchronized void incrementCount(){
processedCount++; 
}

    public void process(List<StatementRecord> records) {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (StatementRecord record : records) {
            executor.submit(() -> {
                processRecord(record);
                
//FIX : calling the synchronized method here to make sure only one thread is //allowed at a time avoiding race condition.Race condition is when 2 or more //threads try to access a resource concurrently

incrementCount();
            });
        }
        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.MINUTES);
    }

    public int getProcessedCount() {
        return processedCount;
    }
}
