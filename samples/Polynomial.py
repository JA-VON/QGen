import random

class Polynomial():
	st = [range(0, 150)]
	degree = 0

	def __init__(self):
		self.generate()

	def generate(self):
		self.degree = random.choice(self.st)

	def __str__(self):
		return "y^" + str(self.degree)

	def get_degree(self):
		return self.deree