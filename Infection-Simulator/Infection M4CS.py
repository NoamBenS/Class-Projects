from math import sqrt
import matplotlib.pyplot as plt
import random


def simulate_epidemic(G, seed, t, p):
    if seed == 0:
        return 0
    if t == 0:
        return len(seed)
    infected = []
    totalInfected = []
    infectedLength = []
    recovered = []
    for i in seed:
        infected.append(G[i])
        totalInfected.append(G[i])
        infectedIndividual = [G[i], int(t)]
        infectedLength.append(infectedIndividual)
    #simulate reinfections
    while len(infected) > 0:
        for i in range(len(infected)):
            for j in range(len(G)):
                if (random.random() <= float(p) and G[i][j] == 1):#given the infectious percentage and if there is a connection
                    if (not infected.__contains__(G[j])) and (not recovered.__contains__(G[j])):
                        infected.append(G[j]) # add element to infected list
                        totalInfected.append(G[j])
                        infectedIndividual = [G[j], int(t)]
                        infectedLength.append(infectedIndividual)
        amountOfTimes = len(infected)
        for k in range(amountOfTimes): #update t for everything
            try:
                newTime = infectedLength[k][1]
            except:
                print("sorry")
            newTime -= 1
            if (newTime > 0):
                infectedLength[k][1] = newTime
            else:
                infected.remove(infectedLength[k][0])
                infectedLength.remove([infectedLength[k][0], newTime + 1])
                recovered.append(G[k])
                k -= 1
    return len(totalInfected)
    # returns one thing: the # of infected


def generate_random_graph(n, p):
    ls = []
    for i in range(n):
        temp = [0]*n
        ls.append(temp)
    for i in range(n):
        for j in range(n):
            if ls[i][j] == 1 or i == j:
                q = 0
            else:
                rand = float(random.random())
                float(p)
                if (rand <= p):
                    ls[i][j] = 1
                    ls[j][i] = 1
    return ls


def average_plots():
    p1 = [0, .1, .2, .3, .4, .5, .6, .7, .8, .9, 1]
    p2 = [0, .1, .2, .3, .4, .5, .6, .7, .8, .9, 1]
    lsx1 = []
    lsx2 = []
    lsz = []
    for i in range(len(p1)):  # for every p1
        n = generate_random_graph(10, p1[i])  # create a new graph
        for j in range(len(p2)):  # then for every in p2
            infected = 0  # set variables to 0
            healthy = 0
            for k in range(100):  # run this next part 100 times
                infected += simulate_epidemic(n, {1}, 1, p2[j])  # run this epidemic thing and add the value to the infected
                healthy += 10 - infected
            infected_avg = infected / 100  # get avg
            healthy_avg = healthy / 100  # get avg
            lsx1.append(infected_avg)  # add avg to infected
            lsx2.append(healthy_avg)  # add avg to healthy
            lsz.append(p2[j])
    plt.scatter(lsz, lsx1, color='hotpink') #average infected
    plt.scatter(lsz, lsx2, color='lightblue')
    plt.show()
    return

#generate_random_graph(10, .2)
average_plots()