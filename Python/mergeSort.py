def merge_sort(array):
    if len(array) <= 1:
        return array
    mid = len(array) // 2
    left, right = merge_sort(array[:mid]), merge_sort(array[mid:])
    return merge(left, right, array.copy())


def merge(left, right, finalMerge):

    leftCursor, rightCursor = 0, 0
    while leftCursor < len(left) and rightCursor < len(right):
        if left[leftCursor] <= right[rightCursor]:
            finalMerge[leftCursor+rightCursor]=left[leftCursor]
            leftCursor += 1
        else:
            finalMerge[leftCursor + rightCursor] = right[rightCursor]
            rightCursor += 1
            
    for leftCursor in range(leftCursor, len(left)):
        finalMerge[leftCursor + rightCursor] = left[leftCursor]
        
    for rightCursor in range(rightCursor, len(right)):
        finalMerge[leftCursor + rightCursor] = right[rightCursor]
    return finalMerge
