from math import sqrt
import matplotlib.pyplot as plt

import random

def simulate_epidemic(G, seed, t, p):
    
    return -1
    #returns one thing: the # of infected


def generate_random_graph(n,p):
    size = sqrt(n)
    size = int(size+.5)
    numberToBeLinked = n*p
    zoinks = int(numberToBeLinked)
    ls = []
    for i in range(n):
        #I want to make an n by n array of nodes of type zero.
        #As they enter, they should be multiplied by the probability
        if(zoinks!=0):
            ls.append(1)
            zoinks-=1
        else:
            ls.append(0)
    random.shuffle(ls)
    output = []
    temp = []
    count = 0
    for i in ls:
        temp.append(i)
        print(temp)
        count+=1
        if(count==size):
            output.append(temp)
            count = 0
            temp.clear()

    return output


def average_plots():
    p1 = [0, .1, .2, .3, .4, .5, .6, .7, .8, .9, 1]
    p2 = [0, .1, .2, .3, .4, .5, .6, .7, .8, .9, 1]
    lsx = []
    lsy = []
    lsz = []
    for i in range(len(p1)): #for every p1
        n = generate_random_graph(10, p1[0]) #create a new graph
        for j in range(len(p1)): #then for every in p2
            infected = 0 # set variables to 0
            healthy = 0
            for i in range(99): #run this next part 100 times
                infected += simulate_epidemic(n, {1}, 1, p2) #run this epidemic thing and add the value to the infected
                healthy += 10 - infected
            infected_avg = infected/100 #get avg
            healthy_avg = healthy/100 #get avg
            lsx.append(infected_avg) #add avg to infected
            lsy.append(healthy_avg) #add avg to healthy
            lsz.append(p2[j])
    plt.scatter(lsx, lsz)
    plt.scatter(lsy, lsz)
    plt.show()
    return

#print(generate_random_graph(10,.2))
average_plots()