# RingBuffer Class

thread-safe ring buffer which fulfills the following requirements:

1. Five generate flow lines in the ring buffer. The string has the 
format "flow generated message № ... ..."
2. The other two flow lines shifted from the first to the second annular 
ring buffer. The second ring buffer line is written the following 
format: "Flow № ... translated message ...".
3. The main flow of the program and prints chastises 100 messages from 
the second
buffer.
