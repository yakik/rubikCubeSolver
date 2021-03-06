from production.cube.cube import Cube
from production.solver.solution_manager import Solution_manager
from production.solver.solution import Solution
from production.solver.rotation_sequence import Rotation_sequence

class Solver:

        def solve(self, p_rubik, p_firstTree, p_secondTree, p_thirdTree):
            l_permutation = Cube(p_rubik)
            l_solutionManager = Solution_manager()
            l_rotationLinkedList = Rotation_sequence()
            l_floor = self.get_target_floor_perm(l_permutation)
            l_numberOfCubicleInPlace = Cube.get_value(l_permutation, l_floor)
            l_solutionManager.add_solution(l_rotationLinkedList, l_permutation, None, l_numberOfCubicleInPlace, l_floor)
            l_solutionToDev = l_solutionManager.get_best_undeveloped()
            while (l_solutionToDev != None and l_solutionManager.get_best_value() < 40):
                targetFloor = self.get_target_floor_perm(l_solutionToDev.get_permutation())
                print("Searching " + str(Cube.get_value(l_solutionToDev.get_permutation(), targetFloor)) + "\n")
                if l_solutionManager.get_best_value() > (Cube.get_value(l_solutionToDev.get_permutation(), targetFloor) + 14):
                    print("Couldn't Find a Solution\n")
                    return l_solutionManager.get_best()
                
                if targetFloor == 1:
                    self.find_better_solution(l_solutionToDev, p_firstTree, l_solutionManager, targetFloor)
                if targetFloor == 2:
                    self.find_better_solution(l_solutionToDev, p_secondTree, l_solutionManager, targetFloor)
                if targetFloor == 3:
                    self.find_better_solution(l_solutionToDev, p_thirdTree, l_solutionManager, targetFloor)

                l_floor = self.get_target_floor_value(l_solutionManager.get_best_value())

                print("Floor="+str(l_floor)+" Best yet:"+str(l_solutionManager.get_best_value())+", best_undeveloped="+str(l_solutionManager.get_best_undeveloped() != None)+"\n")
                l_solutionToDev = l_solutionManager.get_best_undeveloped()
            return l_solutionManager.get_best()

        def get_target_floor_perm(self,p_permutation):
            if Cube.get_value(p_permutation, 1) >= 16:
                if Cube.get_value(p_permutation, 2) < 24:
                    return 2
                else:
                    return 3
            else:
                return 1

        def get_target_floor_value(self, p_value):
            if p_value >= 16:
                if p_value < 24:
                    return 2
                else:
                    return 3
            else:
                return 1

        def find_better_solution(self,p_solution,p_tree,p_solutionManager, p_floor):
            l_rubik = Cube()
            l_permutation = p_solution.get_permutation().get_copy()
            l_minimumValue = Cube.get_value(l_permutation, p_floor)
            l_rubik = Cube(l_permutation)
            self.search_tree(l_minimumValue - 4, p_tree, l_rubik, p_solutionManager, p_solution, p_floor, 0)

        def search_tree(self, minimumValueToReach,searchTree,
                              cubeToSolve,solutionManager,
                              previousSolution, targetFloorToSortInCube, depth):
            if minimumValueToReach < 2:
                minimumValueToReach = 2
            for rotationSequenceIndex in range(0,searchTree.get_size()):
                rotationSequence = searchTree.get_rotationSequence(rotationSequenceIndex)
                if rotationSequence != None:
                    cubeAfterRotationSequence = self.get_cube_after_applying_sequence(Cube(cubeToSolve), rotationSequence)
                    self.add_sequence_to_solution_if_higher_value(minimumValueToReach, solutionManager, previousSolution,
                            targetFloorToSortInCube, rotationSequence, cubeAfterRotationSequence)
                    if targetFloorToSortInCube == 3 and depth == 0:
                        self.search_tree(minimumValueToReach, searchTree, cubeAfterRotationSequence, solutionManager,
                                Solution(rotationSequence, cubeAfterRotationSequence, previousSolution), targetFloorToSortInCube, 1)

        def add_sequence_to_solution_if_higher_value(self, minimumValueToReach,solutionManager,
               previousSolution, targetFloorToSortInCube,rotationSequence,
               cubeAfterRotationSequence):
            if Cube.get_value(cubeAfterRotationSequence, targetFloorToSortInCube) >= minimumValueToReach:
                solutionManager.add_solution(rotationSequence, cubeAfterRotationSequence, previousSolution,
                                            Cube.get_value(cubeAfterRotationSequence, targetFloorToSortInCube), targetFloorToSortInCube)

        def get_cube_after_applying_sequence(self,cubeForExperimentation,rotationSequence):
            for rotationIndex in range(0, rotationSequence.size()):
                cubeForExperimentation.rotate_face(rotationSequence.get_rotation(rotationIndex).getFace(),
                                                   rotationSequence.get_rotation(rotationIndex).getDirection())
            cubeAfterRotationSequence = Cube.get_permutation_from_cube(cubeForExperimentation).get_copy()
            return cubeAfterRotationSequence