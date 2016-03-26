def distractor_1(polynomial):
	return str(polynomial.get_degree() + 1)

def distractor_2(polynomial):
	return str(polynomial.get_degree() - 1000)

def distractor_3(polynomial):
	return str(polynomial.get_degree() + 100)

def distractor_4(polynomial):
	if polynomial.get_degree != 0:
		return "0"

def distractor_5(polynomial):
	return "No such thing as a degree"