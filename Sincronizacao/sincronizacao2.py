#código errado para testar a troca da ordem das chamadas de wait dos semáforos mutex e empty/full

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
        mutex.acquire()  
        empty.acquire()  
        buffer.append(itemP)  
        print(f'{itemP} Produzido')
        full.release()  
        mutex.release()  
        time.sleep(1)  

def consumidor():
    while True:  
        mutex.acquire()
        full.acquire()  
        itemC = buffer.pop(0) 
        print(f'{itemC} Consumido')
        empty.release() 
        mutex.release() 
        time.sleep(1)  

if __name__ == "__main__":
    produtor_thread = threading.Thread(target=produtor)
    consumidor_thread = threading.Thread(target=consumidor)

    produtor_thread.start()
    consumidor_thread.start()

    produtor_thread.join()
    consumidor_thread.join()

    print("Produção e consumo concluídos.")
