$(whoami)
$(date)
$(pwd)
start=$(date +'%s') 
java -jar nFib.jar a
echo "It took $(($(date +'%s') - $start)) seconds"
