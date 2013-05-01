This is a simulation of a web server environment in order to determine the probably that the system will be
down at any any given point in the year. This is one of my first attempts at modeling a system instead of
using of analytical methods to determine its outcomes.

The system is equipped with web routers, web servers, data servers, and a data disk. Each have a mean crash
time and a mean recovery time. The number of minutes any part of the system is down over the course of the
year is produced as output.

In any given second that passes, the system experiences a chance that any of its parts could experience fail-
ure. If any part has failed, these devices experience a probability of recovering in a given minute, as well.
