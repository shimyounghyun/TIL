static void	brain_fuck_algorithm(char *ptr, int loop, char *brain_fuck_ptr)
{
	int	i;

	i = -1;
	while (brain_fuck_ptr[i++])
	{
		if (brain_fuck_ptr[i] == '>')
			++ptr;
		else if (brain_fuck_ptr[i] == '<')
			--ptr;
		else if (brain_fuck_ptr[i] == '+')
			++*ptr;
		else if (brain_fuck_ptr[i] == '-')
			--*ptr;
		else if (brain_fuck_ptr[i] == '.')
			write(1, &*ptr, 1);
		else if (brain_fuck_ptr[i] == ']' && *ptr)
			loop = 1;
			while (loop > 0)
			{
				if (brain_fuck_ptr[--i] == ']')
					++loop;
				else if (brain_fuck_ptr[i] == '[')
					--loop;
			}
	}
}

void		brain_fuck(char *brain_fuck_ptr)
{
	char	array[50000] = {0};
	char	*ptr;
	int	loop;

	ptr = array;
	loop = 0;
	brain_fuck_algorithm(ptr, loop, brain_fuck_ptr);
}

int main(void)
{
	brain_fuck("+++++[>++++[>++++H>+++++i<<-]>>>++\n<<<<-]>>--------.>+++++.>.");
}