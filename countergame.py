from math import *

def get_turn(turns):
    return "Richard" if turns % 2 == 0 else "Louise"

def npot(x):
    exp = floor(log(x, 2))
    r = int(pow(2, exp))
    return r
    
def run_game(n):
    turns = 0
    while(n > 1):
        np = npot(n)
        if np == n:
            n >>= 1
        else:
            n -= np
        turns += 1
    print(get_turn(turns))

t = int(input())
for i in range(t):
    n = int(input())
    run_game(n)
