int readcount =0;
Semaphore mutex =1;
Semaphore w_or_r=1;

writer{
    wait(w_or_r);
    WRITE;
    signal(w_or_r);
}

reader{
    wait(mutex);
    readcount+=1;
    if(readcount==1)
        wait(w_or_r);
    signal(mutex);
    READ;
    wait(mutex);
    readcount-=1;
    if(readcount==0)
        signal(w_or_r);
    signal(mutex);
}