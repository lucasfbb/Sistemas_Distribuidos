Semaphore mutex=1;
Semaphore empty=N;
Semaphore full=0;

producer{
    while(1){
        PRODUCE NEW RESOURCE;
        wait(empty);
        wait(mutex);
        ADD RESOURCE TO AN EMPTY BUFFER;
        signal(mutex);
        signal(full);
    }
}

consumer{
    while(1){
        wait(full);
        wait(mutex);
        REMOVE RESOURCE FROM A FULL BUFFER;
        signal(mutex);
        signal(empty);
        CONSUME RESOURCE;
    }
}