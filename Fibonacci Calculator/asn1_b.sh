$(whoami)
$(date)
$(pwd)
start=$(date +'%s') 
java -jar nFib.jar b
echo "It took $(($(date +'%s') - $start)) seconds"