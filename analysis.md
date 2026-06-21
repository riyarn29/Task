Answer the following three questions:
1.	What is the exact cause of ConcurrentModificationException in Java?

 Ans. ConcurrentModificationException occurs when a collection(e.g ArrayList) is modified after creating an iterator object.

2.	What code pattern at line 142 most likely triggered this error?

Ans. i think an element from the ArrayList was removed while iterating the elements from the list using a for each loop

3.	Provide the minimal code change (one or two lines) that resolves this safely.

      Ans. instead of calling transaction.remove() method we can call iterator.remove()

  Iterator<Transaction> itr   =     transactions.iterator();
 while(itr.hasNext()){
Transaction tx  = itr.next();
if(tx.isInvalid()){
itr.remove();
}
}
