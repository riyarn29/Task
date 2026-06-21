ERROR 2024-04-10 09:14:33 [http-nio-8080-exec-23]
  c.s.dlp.service.StatementProcessorService - Processing failed

java.util.ConcurrentModificationException
  at java.util.ArrayList$Itr.checkForComodification(ArrayList.java:911)
  at java.util.ArrayList$Itr.next(ArrayList.java:861)
  at c.s.dlp.service.StatementProcessorService
       .filterTransactions(StatementProcessorService.java:142)
  at c.s.dlp.service.StatementProcessorService
       .processStatement(StatementProcessorService.java:98)
  at c.s.dlp.controller.StatementController
       .upload(StatementController.java:67)



