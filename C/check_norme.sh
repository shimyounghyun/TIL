#!/bin/sh

if [[ $# -ge 1 ]] ; then
	for i do
			NORM=$(norminette "$i" | grep "error" | wc -l)
			if [[ $NORM -ne "0" ]] ; then
				echo "Error: One or more norm error has been found."
				exit 1
			fi
	done
else
	echo "No arguments given! :("
	exit 2
fi
echo "Norminette passed! :D"
exit 0
