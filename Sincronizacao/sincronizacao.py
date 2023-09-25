import threading
import time

BUFFER_SIZE = 5  
buffer = []  
mutex = threading.Semaphore(1)  
empty = threading.Semaphore(BUFFER_SIZE) 
full = threading.Semaphore(0)  

def produtor():
    while True:  
        itemP = f'Item'
        empty.acquire()  
        mutex.acquire() 
        buffer.append(itemP) 
        print(f'{itemP} Produzido')
        mutex.release()  
        full.release() 
        time.sleep(1)  

def consumidor():
    while True:
        full.acquire()  
        mutex.acquire()
        itemC = buffer.pop(0) 
        print(f'{itemC} Consumido')
        mutex.release()  
        empty.release() 
        time.sleep(1) 

if __name__ == "__main__":
    
    thread_produtor = threading.Thread(target=produtor)
    thread_consumidor = threading.Thread(target=consumidor)

    thread_produtor.start()
    thread_consumidor.start()

    thread_produtor.join() 
    thread_consumidor.join()

    print("Produção e consumo concluídos.")
