

def knapsack(number_of_items,weight_of_the_knapsack,value_array,weight_array):
    if number_of_items == 0 or weight_of_the_knapsack == 0:
        return 0

    if weight_array[number_of_items-1] > weight_of_the_knapsack:
        return knapsack(number_of_items-1,weight_of_the_knapsack,value_array,weight_array)

    if weight_array[number_of_items-1] <= weight_of_the_knapsack:
        include =  value_array[number_of_items-1] + knapsack(number_of_items-1,weight_of_the_knapsack - weight_array[number_of_items-1],value_array,weight_array)


        exclude =  knapsack(number_of_items-1,weight_of_the_knapsack,value_array,weight_array)

        return max(include,exclude)


weights = [1, 2, 3]
values = [6, 10, 12]
W = 5
n = len(weights)
print(knapsack(n, W, values, weights))


