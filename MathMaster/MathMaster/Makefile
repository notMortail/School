# Some settings for the Makefile.
# In particular, you might need to adjust WT_BASE to wherever Wt was installed. /usr/local is the default.

CXX = g++
WT_BASE = /usr/local

CXXFLAGS = --std=c++14 -I$(WT_BASE)/include -I$(WT_BASE)/include/Wt/Dbo  # Include header directories here
#LDFLAGS = -L$(WT_BASE)/lib -Wl,-rpath,$(WT_BASE)/lib -lwthttp -lwt -lboost_thread -lboost_atomic -lboost_filesystem
LDFLAGS = -L$(WT_BASE)/lib -Wl,-rpath,$(WT_BASE)/lib -lwthttp -lwt -lboost_thread -lboost_atomic -lboost_filesystem -lsqlite3

# Identify our code base to be building. Headers and objects are listed under DEPS and OBJS, respectively.

DEPS = MathMaster.h Mode.h  
OBJS = main.o MathMaster.o Mode.o 

# How do we build objects?

%.o: %.cc $(DEPS)
	$(CXX) $(CXXFLAGS) -c -o $@ $<

# How do we build the executable?

mathmaster: $(OBJS)
	$(CXX) $(CXXFLAGS) -o $@ $^ $(LDFLAGS)

# How do we clean up after ourselves?

clean:
	rm -f mathmaster $(OBJS)
