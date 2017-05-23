 # UVG
 # Hoja de trabajo 8
 # Daniel Morales 15526
 # Rodrigo Corona 15102
 # Fernando Hernandez 15476
	


def leerlista():
    archi=open('guategrafo.txt','r')
    linea=archi.readline()  
    while linea!="":        
        primero= linea.find(str)
        segundo= linea.find(str,primero+1)
        tercero= linea.find(str,segundo)
        uno= linea[0:primero]
        dos=linea[primero+1:segundo]
        tres=linea[segundo+1:]
        g.add_edge(uno,dos,weight=int(tres))
        linea=archi.readline()
    archi.close()
import networkx as nx
g = nx.DiGraph()
a=""
lista_nombres=[]
lista_numeros=[]
primero=0
segundo=0
tercero=0
mayor=0
menor="inf"
str=" "
leerlista()
print("Bienvenido al programa")
distancia = [[0 for i in xrange(len(g))] for i in xrange(len(g))]
predecesor, distance = nx.floyd_warshall_predecessor_and_distance(g)
print ("Matriz de distancia mas corta: ")
ni=-1
nj=0
for i in distance:  
    dis = distance[i]
    nj=0
    ni=ni+1
    for j in dis:
        distancia[ni][nj] = dis[j]
        nj=nj+1
print("Columnas/filas(orden):")
for i in distance:
    a=a+','+i
    lista_nombres.append(i)
print a[1:]
for f in distancia:
    print (f)
nx=0
ny=0
for x in distancia:
    nx=0
    for y in range (len (x)):
        if distancia[nx][ny]> mayor:
            mayor=distancia[nx][ny]
        nx=nx+1
    lista_numeros.append(mayor)
    ny=ny+1
for x in range(len(lista_numeros)):
    if lista_numeros[x]<menor:
        menor=lista_numeros[x]
        
print ("El centro del grafo es el nodo:")
print lista_nombres[lista_numeros.index(menor)]