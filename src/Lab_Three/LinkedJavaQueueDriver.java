package Lab_Three;

public class LinkedJavaQueueDriver
{
    public static void main(String[] args)
    {
        // instantiating a LinkedJavaQueue
        LinkedJavaQueue<String> queue = new LinkedJavaQueue<>();

        // adding said elements to the queue
        queue.enqueue("Alisha");
        queue.enqueue("Anna");
        queue.enqueue("Nick");
        System.out.println("Currently waiting:" + queue);

        queue.enqueue("Joy");
        System.out.println("Currently waiting:" + queue);

        queue.enqueue("Brendan");
        queue.enqueue("Rebecca");
        System.out.println("Currently waiting:" + queue);

        queue.dequeue();
        System.out.println("The next customer to be answered is " + queue.first());

        queue.enqueue("Ryan");
        System.out.println("Number of customers: " + queue.size());

        System.out.println("An agent will now answer " + queue.dequeue());
        System.out.println("An agent will now answer " + queue.dequeue());
        System.out.println("An agent will now answer " + queue.dequeue());
        System.out.println("Number of customers: " + queue.size());

        System.out.println("An agent will now answer " + queue.dequeue());
        System.out.println("An agent will now answer " + queue.dequeue());
        System.out.println("Number of customers: " + queue.size());
        System.out.println("Currently waiting:" + queue);

    } // end of main

} // end of LinkedJavaQueueDriver()
