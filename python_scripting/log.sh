#!/bin/bash

file="log.csv"
declare -A dict


while read -r line; do 

  ip=$(grep -Eo "^([[:alnum:]_.]+)[[:space:]]" $line)
  if [[ ! -v dict["$ip"] ]];then
    dict["$ip"]=0
  fi 
  dict["$ip"]=$((dict["$ip"] + 1))

done < $file


for key in "${!dict[@]}"; do
    echo "$key: ${my_dict[$key]}"
done

