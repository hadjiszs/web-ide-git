# $1: clonePath $2:resultPath $3:currentUserName $4:projectName
javac $1/$3/$4/src/*/*.java 2> $2/$3_err.txt > $2/$3_out.txt
