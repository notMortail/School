#include <cstdlib>
#include <deque>
#include <iostream>
#include <list>
#include <memory>
#include <set>
#include <utility>
#include <boost/asio.hpp>
#include "gameState.hpp"
#include "gameServer.cpp"

#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <unistd.h>

using boost::asio::ip::tcp;


class multiplayerSession{
    private:
        int opponentScore;
        //gameServer game;
        char* IP;


    public:
        multiplayerSession(int argc, char* argv[]){
            /*
            try
            {
                if (argc < 2)
                {
                std::cerr << "Usage: chat_server <port> [<port> ...]\n";
                }

                boost::asio::io_service io_service;

                std::list<gameServer> servers;
                for (int i = 1; i < argc; ++i)
                {
                tcp::endpoint endpoint(tcp::v4(), std::atoi(argv[i]));
                servers.emplace_back(io_service, endpoint);
                }

                io_service.run();
            }
            catch (std::exception& e)
            {
                std::cerr << "Exception: " << e.what() << "\n";
            }
            */
        }

        int getIP(){
            const char* auxServer = "8.8.8.8";
            int dns_port = 53;

            struct sockaddr_in serv;
            int sock = socket(AF_INET, SOCK_DGRAM, 0);

            if(sock < 0){
                std::cout << "Socket error";
            }

            struct sockaddr_in name;
            socklen_t namelen = sizeof(name);
            //err = getsocketname(sock, (struct sockaddr*)&name, &namelen)

            char buffer[80];
            const char* p = inet_ntop(AF_INET, &name.sin_addr, buffer, 80);
            if(p!= NULL){
                setIP(buffer);
            }

            close(sock);
            return 0;
        }

        void setIP(char* IPaddr){
            IP = IPaddr;
        };
};
