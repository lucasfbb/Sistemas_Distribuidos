Monitor bounded_buffer{
    Resource buffer[N];
    // Variables for indexing buffer
    Condition not_full, not_empty;

    void put_resource(Resource R){
        while(buffer array is full)
            wait(not_full);
        ADD R TO BUFFER ARRAY;
        signal(not_empty);
    }

    Resource get_resource(){
        while(buffer array is empty)
            wait(not_empty);
        GET RESOURCE R FROM BUFFER ARRAY;
        signal(not_full);
        return R;
    }
}