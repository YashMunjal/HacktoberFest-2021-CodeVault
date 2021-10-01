def partition(arr, begin, end):
    pivot = begin
    for i in xrange(begin+1, end+1):
        if arr[i] <= arr[begin]:
            pivot += 1
            arr[i], arr[pivot] = arr[pivot], arr[i]
    arr[pivot], arr[begin] = arr[begin], arr[pivot]
    return pivot

def quick_sort_recursion(arr, begin, end):
    if begin >= end:
        return
    pivot = partition(arr, begin, end)
    quick_sort_recursion(arr, begin, pivot-1)
    quick_sort_recursion(arr, pivot+1, end)

def quick_sort(arr, begin=0, end=None):
    if end is None:
        end = len(arr) - 1
    
    return quick_sort_recursion(arr, begin, end)
