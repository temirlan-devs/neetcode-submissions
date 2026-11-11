class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        
        rows, cols = len(matrix), len(matrix[0])
        l, r = 0, rows * cols - 1

        while l <= r:
            m = l + (r - l) // 2

            row = m // cols
            col = m % cols

            if matrix[row][col] == target:
                return True

            if matrix[row][col] > target:
                r = m - 1
            else:
                l = m + 1
            
        return False